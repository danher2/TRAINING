import React from 'react'
import { useForm } from '../../hooks/useForm';

export const TodoAdd = ({ handleAddTodo }) => {


    const [{description}, handleInputChange, reset ] = useForm({
        description: ''

    });

    const handleSubmit = (e) => {

        e.preventDefault(); //para evitar el refresh del formulario
        // console.log('nueva tarea')
       
        if ( description.trim().length<= 1 ) {
            return;
        }

        //crea una nueva tarea
        const newTodo = {
            id: new Date().getTime(),
            desc: description,
            done: false
        }

        
        // se lanza la accion al todo reduce
        handleAddTodo(newTodo);

        //resetea el input despues de que se hace el dispatch
        reset();
    
    }


    return (
        <>

            <h4>Agregar TODO</h4>
            <hr />

            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="description"
                    className="form-control"
                    placeholder="Aprender..."
                    autoComplete="off"
                    value={description}
                    onChange={handleInputChange}
                />
                <button
                    type="submit"
                    className="btn btn-outline-primary mt-1 btn-block"
                >
                    Agregar
                </button>

            </form>



        </>
    )
}
