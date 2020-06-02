package container

import component.FilterButtons
import data.State
import data.Display
import react.RClass
import react.RProps
import react.invoke
import react.router.dom.LinkProps
import react.redux.rConnect
import redux.SetDisplayFilter
import redux.WrapperAction

interface SortingLinkProps: RProps {
    var filter: Display
}

private interface LinkStateProps: RProps{
    var active: Boolean
}

private interface LinkDispatchProps: RProps{
    var onClick: () -> Unit
}

val filterLink: RClass<SortingLinkProps> =
    rConnect<
            State,
            SetDisplayFilter,
            WrapperAction,
            SortingLinkProps,
            LinkStateProps,
            LinkDispatchProps,
            LinkProps
            >(
        { _, ownProps ->
            active = Display.All == ownProps.filter
        },
        {dispatch, ownProps ->
            onClick = { dispatch(SetDisplayFilter(ownProps.filter)) }
        }
    )(FilterButtons::class.js.unsafeCast<RClass<LinkProps>>())