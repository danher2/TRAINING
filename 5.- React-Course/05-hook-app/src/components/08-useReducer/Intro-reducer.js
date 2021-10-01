
//TOdos
console.log('Hola Mundo');

const inicialState = [{
    id: 1,
    todo: 'Comprar pan',
    done: false
}];

//Reducer
const todoReducer = (state = inicialState, action) => {


if (action?.type === 'agregar' ) {
    
    return [...state, action.payload];
}


    return state;
}

let todos = todoReducer();

//push modifica o cambia el objet
// todos.push()


//nuevo objeto que queremos agregar
const newTodo = {

    id: 2,
    todo: 'Comprar leche',
    done: false

}

// la accion que agregara el nuevo objeto
const agregarTodoAction = {
    type: 'agregar',
    payload: newTodo
}

// todos variable being modified to add newTodo object throught the action
todos = todoReducer(todos, agregarTodoAction);


console.log(todos);