//estado inicial
const initialState = [{
    id: 1,
    todo: 'Comprar pan',
    done: false
}];

// las acciones SIEMPRE modifican el state
const todoReducer = ( state = initialState, action ) => {
    
    if ( action?.type === 'agregar' ) {
        return [ ...state, action.payload ]; // que me devuelva lo que tiene mi estado , le anado mi nuevo todo y ahora y se actualiza mi estado
    }

    return state;
}

let todos = todoReducer();


const newTodo = {
    id: 2,
    todo: 'Comprar leche',
    done: false
}


const agregarTodoAction = {
    type: 'agregar',
    payload: newTodo
}


todos = todoReducer( todos, agregarTodoAction );



console.log(todos);

