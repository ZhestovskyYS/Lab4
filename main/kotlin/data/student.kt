package data

data class Student (
    val firstname: String,
    val surname: String,
    var presence: Boolean
)

val studentList =
    arrayListOf(
        Student("Sheldon", "Cooper", true),
        Student("Leonard", "Hofstadter", true),
        Student("Yan", "Zhestovsky", true),
        Student("Howard", "Wolowitz", true)
    )