import React, { useRef } from 'react'
import '../02-useEffect/effects.css'

export const FocusScreen = () => {
  
    //activamos el useRef para referenciar
    const inputRef = useRef();
    // console.log(ref);
    
    
    const handleCLick = () => {
        inputRef.current.select();
        console.log(inputRef);
    }
  
  
    return (
        <div>
           <h1>Focus Screen</h1> 
           <hr/>
          
           <input
            ref  = { inputRef } //hace referencia al input
            className="form-control"
            placeholder="Su nombre" 
           />

           <button 
           className = "btn btn-outline-primary mt-5"
           onClick={ handleCLick }
           >Focus</button>
        </div>
    )
}
