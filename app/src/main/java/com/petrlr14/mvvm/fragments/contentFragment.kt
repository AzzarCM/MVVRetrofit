package com.petrlr14.mvvm.fragments
/*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.petrlr14.mvvm.R
import com.petrlr14.mvvm.database.entities.GitHubRepo
import com.petrlr14.mvvm.database.viewmodels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_content_fragment.*

class contentFragment : Fragment() {
    lateinit var repos: GitHubRepo
    lateinit var viewModel: GitHubRepoViewModel

    companion object{
        fun newInstance (repos: GitHubRepo):contentFragment{
            val newFragment = contentFragment()
            newFragment.repos = repos
            return  newFragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.activity_content_fragment,container,false)

        viewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)

        if(savedInstanceState != null) repos = savedInstanceState.getParcelable("keyFlag")

        bindData(view)
        return view
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("keyFlag", repos)
    }

    private fun bindData(view: View?) {
        tv_repos.text = repos.name
    }
}
*/
