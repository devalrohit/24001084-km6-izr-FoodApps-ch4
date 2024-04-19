package com.catnip.appfoos_rohit.data.datasource.user

import com.catnip.appfoos_rohit.data.model.User
import com.catnip.appfoos_rohit.data.model.toUser
import com.catnip.appfoos_rohit.data.source.network.firebase.FirebaseService
import java.lang.Exception

interface AuthDataSource {

    @Throws(exceptionClasses = [Exception::class])
    suspend fun doLogin(email : String, password : String) : Boolean

    @Throws(exceptionClasses = [Exception::class])
    suspend fun doRegister(username:String, email : String, password : String) : Boolean

    suspend fun updateProfile(username : String? = null) : Boolean

    suspend fun updatePassword(newPassword : String) : Boolean

    suspend fun updateEmail(newEmail : String) : Boolean

    fun requestChangePasswordByEmail() : Boolean

    fun doLogout():Boolean

    fun isLoggedIn(): Boolean

    fun getCurrentUser():User?

}

class FirebaseAuthDataSource(private val service : FirebaseService) : AuthDataSource {
    override suspend fun doLogin(email: String, password: String): Boolean {
        return service.doLogin(email, password)
    }

    override suspend fun doRegister(
        username:String, email : String, password : String
    ): Boolean {
        return service.doRegister(
            username = username,
            email = email,
            password = password
        )
    }

    override suspend fun updateProfile(username: String?): Boolean {
        return service.updateProfile(username)
    }

    override suspend fun updatePassword(newPassword: String): Boolean {
        return service.updatePassword(newPassword)
    }

    override suspend fun updateEmail(newEmail: String): Boolean {
        return service.updateEmail(newEmail)
    }

    override fun requestChangePasswordByEmail(): Boolean {
        return service.requestChangePasswordByEmail()
    }

    override fun doLogout(): Boolean {
        return service.doLogout()
    }

    override fun isLoggedIn(): Boolean {
        return service.isLoggedIn()
    }

    override fun getCurrentUser(): User? {
        return service.getCurrentUser().toUser()
    }
}