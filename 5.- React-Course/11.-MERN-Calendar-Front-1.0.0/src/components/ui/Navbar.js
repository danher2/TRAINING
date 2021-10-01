import React from 'react'

// constuimos el navbar con  estilos de Bootstrap
export const Navbar = () => {
    return (
        <div className="navbar navbar-dark bg-dark mb-4">
            <span className="navbar-brand">
                Pedro
            </span>
            
            <button className="btn btn-outline-danger">
                <i className="fas fa-sign-out-alt"></i> {/* icono de font awesome */}
                <span> Salir</span>
            </button>

        </div>
    )
}
