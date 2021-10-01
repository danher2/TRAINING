import React, { useEffect, useReducer } from 'react'
// import { useForm } from '../../hooks/useForm'
import './styles.css'
import { TodoAdd } from './TodoAdd'
import { TodoList } from './TodoList'
import { todoReduce } from './todoReduce'




const init  = () => {


return JSON.parse(localStorage.getItem('todos')) || [];

    // return [{

    //     id: new Date().getTime(),
    //     desc: 'Aprender React',
    //     done: false
    
    // }]

}


export const TodoApp = () => {

    //dispatch una funcion a la que mandamos la accion
    const [todos, dispatch] = useReducer(todoReduce, [],init)


    //
    

    useEffect(() => {
        localStorage.setItem('todos', JSON.stringify(todos))
    }, [todos]) // si lostodos cambian significa que tengo que grabar en el localstorage





    const handleDelete = (todoId) => {
        console.log(todoId);

        //crear la accion
        const action = {
            type: 'delete',
            payload: todoId
        }

        //hacer el dispatch
        dispatch(action);
    }



    //tacha la <p>  ucuando es true o false
    const handleToggle = (todoId) => {

        dispatch({
            type: 'toggle',
            payload: todoId
        })
        
    }


    const handleAddTodo = (newTodo) => {

         dispatch({
            type: 'add',
            payload: newTodo
        })


    }
    

   


    return (
        <div>
            <h1>Todo App ({todos.length})</h1>
            <hr />

            <div className="row">
                <div className="col-7">

                    {/* TodoList, argumentos: todos,handleDelete, handleToggle */}
                    <TodoList 
                        todos = { todos }
                        handleDelete = { handleDelete }
                        handleToggle = { handleToggle }
                    />
                </div>
                <div className="col-5">

                    {/* agrega todos por medio de la funcion handleAddTodo */}
                    <TodoAdd 
                    handleAddTodo = { handleAddTodo }
                    />


                </div>

            </div>


        </div>
    )
}
