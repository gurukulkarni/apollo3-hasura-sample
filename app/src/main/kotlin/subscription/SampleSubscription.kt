package subscription

import com.apollographql.apollo3.ApolloClient

class SampleSubscriptions(private val apolloClient: ApolloClient) {
    suspend fun execute() {
        println("-- starting subscription -- ")
        apolloClient.subscription(SampleSubscription())
            .toFlow()
            .collect {
                    println("current_epoch via subscription ${it.data?.alarmdata_current_server_time?.get(0)?.current_epoch_seconds}")
            }
    }
}