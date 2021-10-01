import React, { useCallback, useState } from 'react'
import '../02-useEffect/effects.css'
import { ShowIncrement } from './ShowIncrement';

export const CallbackHooks = () => {
    
    
    const [counter, setcounter] = useState(10);
   
    // const increment = ()=> {
    //     setcounter(counter + 1);
    // }

        //siempre que se mande una funcion como atributo en un componente
    const increment =  useCallback((num) => {
        setcounter(counter => counter + num); // establecemos la funcionalidad de incremento en el setCounter
        },[setcounter]  )
    
    
    
    return (
        <div>
           <h1>useCallback Hook: { counter }</h1>
           <hr/> 

        {/* boton en el Showincrement */}
        <ShowIncrement increment = { increment }/>
        </div>
    )
}
