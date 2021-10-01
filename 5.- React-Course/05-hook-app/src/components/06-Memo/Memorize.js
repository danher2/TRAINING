import React, {useState} from 'react';
import { useCounter } from '../../hooks/useCounter';
import '../02-useEffect/effects.css';
import { Small } from './Small';

export const Memorize = () => {

    const {counter,increment} = useCounter(10); // dispara la renderizacin de nuestro componente
    const [show, setshow] = useState(true)

    return (
        <div>
            <h1>Conter <Small value = {counter} /> </h1>
            <hr/>

            <button
            className = "btn btn-primary"
            onClick =  { increment }
            >+1</button>


            <button
            className = "btn btn-outline-primary ml-3"
            onClick = {()=>{
                setshow(!show);
            }}
            
            >Show/Hide {JSON.stringify( show )}</button>
        </div>
    )
}
