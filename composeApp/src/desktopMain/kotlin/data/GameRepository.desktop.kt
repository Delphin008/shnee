package data

import GameState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import util.gelds

actual class GameRepositoryImpl actual constructor() : GameRepository {

    private var _memory: MutableStateFlow<GameState> = MutableStateFlow(GameState(0.gelds, emptyList()))

    override fun getGame(): Flow<GameState> = _memory

    override fun saveGame(gameState: GameState) {
        _memory.update { gameState }
    }
}