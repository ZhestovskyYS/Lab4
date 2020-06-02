package container

import component.AnyFullProps
import component.fAnyFull
import component.lesson
import component.student
import data.*
import hoc.withDisplayName
import org.w3c.dom.events.Event
import react.RBuilder
import react.RClass
import react.RProps
import react.invoke
import redux.*
import react.redux.rConnect

interface DispatchProps: RProps{
    var onClick: (Int) -> (Event) -> Unit
}

interface FullStateProps<O,S>: RProps{
    var subobjs: Map<Int, S>
    var presents: Map<Int, Boolean>?
}

interface FullProps<O>: RProps{
    var obj: Pair<Int, O>
}

val lessonFullContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            FullProps<Lesson>,
            FullStateProps<Lesson, Student>,
            DispatchProps,
            AnyFullProps<Lesson, Student>
            >(
        {state, props ->
            subobjs = studentsToDisplay(
                state.students,
                state.presents[props.obj.first],
                state.filter)
            presents = state.presents[props.obj.first]
        },
        {dispatch, props ->
            onClick =
                {index ->
                    {
                        dispatch(ChangePresent(props.obj.first, index))
                    }
                }
        }
    )(
        withDisplayName(
            "LessonFull",
            fAnyFull<Lesson, Student>(RBuilder::student)
        )
            .unsafeCast<RClass<AnyFullProps<Lesson, Student>>>()
    )

val studentFullContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            FullProps<Student>,
            FullStateProps<Student, Lesson>,
            DispatchProps,
            AnyFullProps<Student, Lesson>
            >(
        {state, props ->
            subobjs = lessonPresent(
                state.lessons,
                state.presentsStudent(props.obj.first),
                state.filter
            )
            presents = state.presentsStudent(props.obj.first)
        },
        {dispatch, props ->
            onClick = {index ->{
                dispatch(ChangePresent(index, props.obj.first))
                }
            }
        }
    )(
        withDisplayName(
            "StudentFull",
            fAnyFull<Student, Lesson>(RBuilder::lesson)
        )
            .unsafeCast<RClass<AnyFullProps<Student, Lesson>>>()
    )

private fun studentsToDisplay(
    students: Map<Int ,Student>,
    presents: Map<Int, Boolean>?,
    display: Display
) =
    when(display){
        Display.All-> students
        Display.ThosePresent -> {
            val present = students.toMutableMap()
            present.clear()
            presents?.filter { it.value }?.map{
                present[it.key] = students.getValue(it.key)
            }
            present
        }
        Display.ThoseMissing -> {
            val absent= students.toMutableMap()
            absent.clear()
            presents?.filter { !it.value }?.map {
                absent[it.key] = students.getValue(it.key)
            }
            absent
        }
    }

private fun lessonPresent(
    lessons: Map<Int, Lesson>,
    presents: Map<Int, Boolean>?,
    display: Display
) =
    when(display){
        Display.All-> lessons
        Display.ThosePresent -> {
           val present= lessons.toMutableMap()
           present.clear()
           presents?.filter { it.value }?.map{
               present[it.key] = lessons.getValue(it.key)
           }
           present
        }
        Display.ThoseMissing -> {
            val absent= lessons.toMutableMap()
            absent.clear()
            presents?.filter { !it.value }?.map {
                absent[it.key] = lessons.getValue(it.key)
            }
            absent
        }
    }