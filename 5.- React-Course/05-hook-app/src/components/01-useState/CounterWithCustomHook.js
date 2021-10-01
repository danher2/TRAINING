import React from 'react';
import { useCounter } from '../../hooks/useCounter';
import './counter.css';

const CounterWithCustomHook = () => {
   
   
   
   const {state, increment, decrement, reset} = useCounter(2000);
   
   
   
    return (
        <>

        <h1>Counter with hook {state} </h1>
        <hr/>

        <button onClick = { () => increment(2)} className = "btn">+1</button>
        <button onClick = { reset } className = "btn">reset</button>
        <button onClick = { () => decrement(2)} className = "btn">-1</button>

        </>
    )
}

export default CounterWithCustomHook
