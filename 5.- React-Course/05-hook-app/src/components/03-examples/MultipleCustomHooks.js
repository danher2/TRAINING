import React from 'react'
import { useCounter } from '../../hooks/useCounter';
import { useFetch } from '../../hooks/useFetch';
import './effects.css';

export const MultipleCustomHooks = () => {


  const { counter, increment } = useCounter(1)


  const { loading, data } = useFetch(`https://www.breakingbadapi.com/api/quotes/${counter}`);
  //    console.log(loading,data);

  const { author, quote } = !!data && data[0];
  console.log(author, quote);



  return (
    <div>
      <h1>BreakingBad Quotes</h1>
      <hr />


      { // si loading es true 
        loading ? (<div className="alert alert-info text-center">Loading...</div>)
          : // si no es true entonces...
          (<blockquote className="blockquote text-end">
            <p className="mb-0">{quote}</p>
            <footer className="blockquote-footer mt-1">{author}</footer>
          </blockquote>)

      }

      <button
        className="btn btn-primary"
        onClick={increment}
      >Siguiente quote
      </button>








    </div>


  )
}
