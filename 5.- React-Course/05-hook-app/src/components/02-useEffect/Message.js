import React, { useEffect, useState} from 'react'





export const Message = () => {

    const [coords, setCoords] = useState({x:0,y:0})
    const {x,y} = coords;

   
   useEffect(() => {
    //    console.log('componente Montado')
    //se dispara
    const mouseMove= (e)=>{
        const newCoords = {x: e.x, y: e.y}
        setCoords(newCoords);
    }

    window.addEventListener('mousemove', mouseMove)
       
       
       return () => {
           //se hace limpieza
          window.removeEventListener('mousemove', mouseMove);
       }
   }, [])

 

      
   
   
   
   
    return (
        <div>
            <h3>Eres genial</h3>
            <p>
                x: {x} y: {y}
            </p>
        </div>
    )
}
