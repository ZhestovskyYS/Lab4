package container

import component.AppProps
import component.fApp
import data.State
import hoc.withDisplayName
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect

val appContainer =
    rConnect<State, RProps, AppProps>(
        {state, _ ->
            lessons = state.lessons
            students = state.students
        },
        {
            pure = false
        }
    )(
        withDisplayName(
            "MyApp",
            fApp()
        )
            .unsafeCast<RClass<AppProps>>()
    )