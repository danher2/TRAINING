import React, { useContext } from 'react'
import { UserContext } from './UserContext'

export const HomeScreen = () => {
   
    //que busque la instancia de en el arbol de componente que sea de tipo UserContext
   const {user} = useContext(UserContext)
   console.log(user); //imprime el value que definimos en el userContext del MainApp
   
   
    return (
        <div>
            <h1>HomeScreen</h1>
            <hr/>

            <pre>

                {JSON.stringify(user,null,3) }

            </pre>
        </div>
    )
}
