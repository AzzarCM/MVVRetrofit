package com.petrlr14.mvvm.fragments
/*
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.petrlr14.mvvm.R
import com.petrlr14.mvvm.adapter.ReposAdapter
import com.petrlr14.mvvm.database.entities.GitHubRepo
import com.petrlr14.mvvm.database.viewmodels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_list_fragment.*

class fragementList : Fragment() {

    lateinit var viewModel: GitHubRepoViewModel
    lateinit var reposAdapter: ReposAdapter
    var flag : Boolean = true
    var click:OnFragmentInteractionListener? =  null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_list_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)

        if(savedInstanceState != null) flag = savedInstanceState.getBoolean("keyFlag")

        initRecyclerView(resources.configuration.orientation ,view)
        return view
    }

    private fun initRecyclerView(orientation: Int, view: View?) {
        val linearLayoutManager = LinearLayoutManager(this.context)
        if(orientation == Configuration.ORIENTATION_PORTRAIT) reposAdapter = ReposAdapter(ArrayList())
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) reposAdapter = ReposAdapter(ArrayList())
        recyclerviewList.adapter = reposAdapter
        if (flag){
            viewModel.getAll().observe(this, Observer { repos->
                repos?.let {
                    reposAdapter.updateList(it) }
            })
        }
        recyclerviewList.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
        }

    }

    interface OnFragmentInteractionListener {
        fun portraitItemClick(gitHubRepo: GitHubRepo)

        fun landscapeItemClick(gitHubRepo: GitHubRepo)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("keyFlag", flag)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            click = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        click = null
    }

    companion object {
        fun newInstance(flag : Boolean): fragementList{
            val newFragment = fragementList()
            newFragment.flag = flag
            return newFragment
        }
    }
}
*/
