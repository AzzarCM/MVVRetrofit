package com.petrlr14.mvvm.activities

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.petrlr14.mvvm.R
import com.petrlr14.mvvm.adapter.ReposAdapter
import com.petrlr14.mvvm.database.entities.GitHubRepo
import com.petrlr14.mvvm.database.viewmodels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    lateinit var adapter:ReposAdapter
    lateinit var viewModel:GitHubRepoViewModel
/*    lateinit var listFragment: fragementList

    override fun portraitItemClick(gitHubRepo: GitHubRepo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun landscapeItemClick(gitHubRepo: GitHubRepo) {
        var contentFragment = contentFragment.newInstance(gitHubRepo)
        changeFragment(R.id.land_main_cont_fragment, contentFragment)
    }
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*listFragment = fragementList.newInstance(false)

        val resource = if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            R.id.frameLayoutMain
        else {
            R.id.land_main_fragment
        }
        changeFragment(resource, listFragment)
*/
        bind()
    }
    private fun bind(){
        adapter= ReposAdapter(ArrayList())
        viewModel=ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)
        rv_repos.apply {
            adapter=this@MainActivity.adapter
            layoutManager=LinearLayoutManager(this@MainActivity)
        }
        viewModel.getAll().observe(this, Observer {
            adapter.updateList(it)
        })
        btn_repo.setOnClickListener {
            viewModel.retrieveRepo(et_repo.text.toString())
        }
    }

    private fun changeFragment(id: Int, frag: Fragment){ supportFragmentManager.beginTransaction().replace(id, frag).commit() }

}
