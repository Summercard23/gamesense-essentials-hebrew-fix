package eu.tricht.gamesense.model

data class SongInformation(
    val fullSongName: String
) {
    private fun isHebrew(text: String): Boolean {
        return text.any { it in '\u0590'..'\u05FF' }
    }

    private fun fixHebrew(text: String): String {
        return if (isHebrew(text)) {
            text.reversed()
        } else text
    }

    private val artistText = ScrollingText(fixHebrew(fullSongName.split(" - ").getOrElse(0) { "" }))
    private val songText = ScrollingText(fixHebrew(fullSongName.split(" - ").getOrElse(1) { "" }))

    fun artist() = artistText.text
    fun song() = songText.text
}
