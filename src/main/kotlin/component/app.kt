package component

import data.*
import hoc.withDisplayName
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import react.router.dom.*
import redux.*
import kotlin.browser.document

interface AppProps : RProps {
    var store: Store<State, RAction, WrapperAction>
}

interface RouteNumberResult : RProps {
    var number: String
}

fun fApp() =
    functionalComponent<AppProps> { props ->
        header {
            h1 { +"App" }
            nav {
                ul {
                    li { navLink("/lessons") { +"Lessons" } }
                    li { navLink("/students") { +"Students" } }
                    li { navLink("/redactStudents") { +"Change student list" } }
                    li { navLink("/redactLessons") { +"Change lessons list" } }
                }
            }
        }

        switch {
            route("/lessons",
                exact = true,
                render = {
                    anyList(
                        props.store.getState().lessons,
                        "Lessons",
                        "/lessons",
                        props.DeletingLesson()
                    )
                }
            )
            route("/students",
                exact = true,
                render = {
                    anyList(
                        props.store.getState().students,
                        "Students",
                        "/students",
                        props.DeletingStudent()
                    )
                }
            )
            route("/lessons/:number",
                render = renderLesson(props)
            )
            route("/students/:number",
                render = renderStudent(props)
            )
            route("/redactStudents",
                render = redactStudent(props)
            )
            route("/redactLessons",
                render = redactLesson(props)
            )
        }
    }

fun AppProps.onClickStudent(num: Int): (Int) -> (Event) -> Unit =
    { index ->
        {
            store.dispatch(ChangePresent(index, num))
        }
    }

fun AppProps.onClickLesson(num: Int): (Int) -> (Event) -> Unit =
    { index ->
        {
            store.dispatch(ChangePresent(num, index))
        }
    }

fun AppProps.AddingStudent(): (Event) -> Unit ={
    val firstName = document.getElementById("FName") as HTMLInputElement
    val sureName = document.getElementById("SName") as HTMLInputElement
    store.dispatch(AddStudent(firstName.value, sureName.value))
}

fun AppProps.DeletingStudent(): (Int) -> Unit = {index ->
    store.dispatch(DeleteStudent(index))
}

fun AppProps.AddingLesson(): (Event) -> Unit = {
    val lesson = document.getElementById("lesson") as HTMLInputElement
    store.dispatch(AddLesson(lesson.value))
}

fun AppProps.DeletingLesson(): (Int) -> Unit = {index ->
    store.dispatch(DeleteLesson(index))
}

fun RBuilder.renderLesson(props: AppProps) =
    { route_props: RouteResultProps<RouteNumberResult> ->
        val num = route_props.match.params.number.toIntOrNull() ?: -1
        val lesson = props.store.getState().lessons.getOrNull(num)
        if (lesson != null)
            anyFull(
                RBuilder::student,
                lesson,
                props.store.getState().students,
                props.store.getState().presents[num],
                props.onClickLesson(num)
            )
        else
            p { +"No such lesson" }
    }

fun RBuilder.renderStudent(props: AppProps) =
    { route_props: RouteResultProps<RouteNumberResult> ->
        val num = route_props.match.params.number.toIntOrNull() ?: -1
        val student = props.store.getState().students.getOrNull(num)
        if (student != null)
            anyFull(
                RBuilder::lesson,
                student,
                props.store.getState().lessons,
                props.store.getState().presents.map {
                    it[num]
                }.toTypedArray(),
                props.onClickStudent(num)
            )
        else
            p { +"No such student" }
    }

fun RBuilder.redactStudent(props: AppProps): () -> ReactElement = {
    redactList(
        RBuilder::anyList,
        RBuilder::StudentField,
        props.store.getState().students,
        props.AddingStudent(),
        props.DeletingStudent(),
        "Students",
        "/students"
    )
}

fun RBuilder.redactLesson(props: AppProps): () -> ReactElement = {
    redactList(
        RBuilder::anyList,
        RBuilder::LessonField,
        props.store.getState().lessons,
        props.AddingLesson(),
        props.DeletingLesson(),
        "Lessons",
        "/lessons"
    )
}

fun RBuilder.app(
    store: Store<State, RAction, WrapperAction>
) =
    child(
        withDisplayName("App", fApp())
    ) {
        attrs.store = store
    }





