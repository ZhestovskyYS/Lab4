package redux

class ChangePresent(val lesson: Int, val student: Int) : RAction
class AddStudent(val name: String, val surname: String): RAction
class DeleteStudent(val i: Int): RAction
class AddLesson(val lesson: String): RAction
class DeleteLesson(val i: Int): RAction