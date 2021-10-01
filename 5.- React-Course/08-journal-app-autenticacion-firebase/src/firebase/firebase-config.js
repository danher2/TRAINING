// lo que necesitamos
import firebase from 'firebase/app';
import 'firebase/firestore';
import 'firebase/auth';

var firebaseConfig = {
    apiKey: "AIzaSyDf1IED5XmjPw8i28Hyou_QWY0Afinq0DY",
    authDomain: "reactappcourse-d183f.firebaseapp.com",
    projectId: "reactappcourse-d183f",
    storageBucket: "reactappcourse-d183f.appspot.com",
    messagingSenderId: "262497067790",
    appId: "1:262497067790:web:b012fc3dff1c40bf7ced5f"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);


//referencia a mi base de datos
const db = firebase.firestore();

//autenticacion con google
const googleAuthProvider = new firebase.auth.GoogleAuthProvider();


export {
    db,
    googleAuthProvider,
    firebase
}


