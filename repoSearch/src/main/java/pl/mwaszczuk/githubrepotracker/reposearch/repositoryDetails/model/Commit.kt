package pl.mwaszczuk.githubrepotracker.reposearch.repositoryDetails.model

import androidx.compose.runtime.Immutable

@Immutable
data class Commit(
    val sha: String,
    val message: String,
    val authorName: String,
    val isSelected: Boolean = false
) {
    override fun toString(): String {
        return "Commit $sha\nAuthor $authorName\nMessage $message\n\n\n"
    }
}
