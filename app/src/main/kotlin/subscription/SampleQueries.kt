package subscription

import com.apollographql.apollo3.ApolloClient

class SampleQueries(private val apolloClient: ApolloClient) {
    suspend fun execute() {
        val response = apolloClient.query(SampleQuery()).execute()
        println("current_epoch via query ${response.data?.alarmdata_current_server_time?.get(0)?.current_epoch_seconds}")
    }
}