import React from 'react'

//history viene de las props del componente LoginScreen que se derivan del Router provider
export const LoginScreen = ({history}) => {
   
  const handleClick = () => {

    // console.log('click');
    //lamamos la funcion push de la prop history para que redireccione a la rua '/'
    // history.push('/');
    history.replace('/');
  }
  
  
  
  
  
  
  
  return (
        <div className = "container mt-5">
          <h1>Login</h1>  
          <hr />
          
        <button
        className = "btn btn-primary"
        onClick = {handleClick}
        >Login</button>


        </div>
    )
}
