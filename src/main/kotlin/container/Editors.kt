package container

import component.LessonEditProps
import component.StudentEditProps
import component.fLessonEdit
import component.fStudentEdit
import data.Lesson
import data.Student
import hoc.withDisplayName
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import redux.ChangeLesson
import redux.ChangeStudent
import redux.RAction
import redux.WrapperAction

interface LessonEditProps: RProps{
    var lesson: Pair<Int, Lesson>
}

val lessonEditContainer =
    rConnect<
            RAction,
            WrapperAction,
            container.LessonEditProps,
            LessonEditProps
            >(
        {dispatch, props ->
            onClick = {
                dispatch(ChangeLesson(props.lesson.first, it))
            }
        }
    )(
        withDisplayName(
            "LessonEdit",
            fLessonEdit
        )
            .unsafeCast<RClass<LessonEditProps>>()
    )

interface StudentEditProps: RProps{
    var student: Pair<Int, Student>
}

val studentEditContainer =
    rConnect<
            RAction,
            WrapperAction,
            container.StudentEditProps,
            StudentEditProps
            >(
        {dispatch, props ->
            onClick={
                dispatch(ChangeStudent(props.student.first, it))
            }
        }
    )(
        withDisplayName(
            "StudentEdit",
            fStudentEdit
        )
            .unsafeCast<RClass<StudentEditProps>>()
    )