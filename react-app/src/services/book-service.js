import http from './axios-common';

export function getAllBooks(){
    return http.get("/books");
}

export function getALLBookByMaturityDate(){
    return http.get("/books/maturity/date");
}

export function postLogin(){
    return http.post("/login");
}