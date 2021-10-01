import React from 'react'


//React.memo=que memorice el componente si los argumentos no cambian
export const ShowIncrement = React.memo(({increment}) => {
    
    console.log('me volvi a generar :(');
    
    
    return (
        
            <button
            className = "btn btn-primary"
            onClick = { () => {
                increment(5);
            }}
            >Incrementar</button>
        
    )
})
