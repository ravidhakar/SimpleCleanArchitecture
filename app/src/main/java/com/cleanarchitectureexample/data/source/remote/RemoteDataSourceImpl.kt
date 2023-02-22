package com.cleanarchitectureexample.data.source.remote

import com.cleanarchitectureexample.data.model.UserDTO
import org.json.JSONObject

class RemoteDataSourceImpl : RemoteDataSource {
    private val userJSON = "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"Ravi Dhakar\",\n" +
            "  \"mobile\": \"8839919254\"\n" +
            "}"

    override suspend fun getUser(): UserDTO {
        return fetchUser()
    }

    private fun fetchUser(): UserDTO {
        val json = JSONObject(userJSON)
        return UserDTO(json.getInt("id"), json.getString("name"), json.getString("mobile"))
    }
}