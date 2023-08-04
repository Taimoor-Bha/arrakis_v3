import http from './axios-common';

export function getAllUsers(){
    return http.get("/users")
}

