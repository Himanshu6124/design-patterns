package low_level_designs.spotify.manager


import low_level_designs.spotify.enums.PlayStrategyType
import low_level_designs.spotify.strategy.CustomQueueStrategy
import low_level_designs.spotify.strategy.PlayStrategy
import low_level_designs.spotify.strategy.RandomPlayStrategy
import low_level_designs.spotify.strategy.SequentialPlayStrategy

class StrategyManager private constructor() {

    private val sequentialStrategy = SequentialPlayStrategy()
    private val randomStrategy = RandomPlayStrategy()
    private val customQueueStrategy = CustomQueueStrategy()

    fun getStrategy(type: PlayStrategyType): PlayStrategy {
        return when (type) {
            PlayStrategyType.SEQUENTIAL -> sequentialStrategy
            PlayStrategyType.RANDOM -> randomStrategy
            PlayStrategyType.CUSTOM_QUEUE -> customQueueStrategy
        }
    }

    companion object {
        @Volatile
        private var instance: StrategyManager? = null

        fun getInstance(): StrategyManager {
            return instance ?: synchronized(this) {
                instance ?: StrategyManager().also {
                    instance = it
                }
            }
        }
    }
}