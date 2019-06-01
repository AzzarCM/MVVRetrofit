package com.petrlr14.mvvm.database.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.petrlr14.mvvm.database.RoomDB
import com.petrlr14.mvvm.database.entities.GitHubRepo
import com.petrlr14.mvvm.database.repositories.GitHubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubRepoViewModel(private val app: Application) : AndroidViewModel(app) {

    private val repository: GitHubRepoRepository

    init {
        val repoDao=RoomDB.getInstance(app).repoDao()
        repository= GitHubRepoRepository(repoDao)
    }

    private suspend fun insert(repo:GitHubRepo)=repository.insert(repo)

    fun getAll():LiveData<List<GitHubRepo>>{
        return repository.getAll()
    }

    private suspend fun nuke()= repository.nuke()

    fun retrieveRepo(user:String) = viewModelScope.launch {

        //borramos la tabla de repositorios

        this@GitHubRepoViewModel.nuke()

        //obtenemos la respuesta de la request
        val response = repository.retrieveReposAsync(user).await()

        if(response.isSuccessful) with(response){
            this.body()?.forEach{
                this@GitHubRepoViewModel.insert(it)
            }
        }else with(response){
            println(this.code())
            when(this.code()){
                400->{
                    Toast.makeText(app,"RIP", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}