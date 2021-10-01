import React from 'react'
import { Navbar } from '../components/ui/Navbar'
import {
    Switch,
    Route,
    Redirect
  } from "react-router-dom";
import { MarvelScreen } from '../components/marvel/MarvelScreen';
import { HeroScreen } from '../components/heroes/HeroScreen';
import { DcScreen } from '../components/dc/DcScreen';

export const DashboardRoutes = () => {
    return (
        <>

        <Navbar /> 

        <div className = "container mt-2">
        <Switch >
            <Route  exact path = "/marvel"  component = {MarvelScreen}/>
           {/* se le manda un argumento y se especifica asi: /:heroeId */}
            <Route  exact path = "/heroe/:heroeId"  component = {HeroScreen}/>
            <Route  exact path = "/dc"  component = {DcScreen}/>

            <Redirect to  = "/marvel" />



        </Switch>


        </div>


        </>
    )
}
