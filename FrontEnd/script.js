let loginForm = document.querySelector('#login>form');

loginForm.onsubmit = function(){
    event.preventDefault();

    let Obj = {
        'username': loginForm.username.value,
        'password': loginForm.password.value
    }

    const logInUser = async () => {
        let options = {
                method: "POST",
                headers: {
                        "Content-type": "application/json"
                },
                body: JSON.stringify(Obj),
        }
        let p = await fetch('http://localhost:8880/user/login', options)
        let response = await p.json()
        console.log(response);
        return response
    };

    if(logInUser!=null){
        alert("Login Sucessfull");
        window.location.href="profile.html";
    }else{
        alert("Invalid Username Or Password");
    }

}

// registration
let regiForm = document.querySelector('#registration>form');

regiForm.onsubmit = function(){
     let Obj = {
        'username':regiForm.name.value,
        'dob':regiForm.Dob.value,
        'age':regiForm.age.value,
        'gender':regiForm.gender.value,
        'email':regiForm.email.value,
        'city':regiForm.city.value,
        'profileImage':regiForm.image.value,
        'password':regiForm.password.value
    }

    const registerApplicant = async () => {
        let options = {
                method: "POST",
                headers: {
                        "Content-type": "application/json"
                },
                body: JSON.stringify(Obj),
        }
        let p = await fetch('http://localhost:8880/user/register', options)
        let response = await p.json()
        console.log(response);
        return response
    }

    // registration successfull alert
    if(registerApplicant!=null){
        alert("Applicant Registered Sucessfully");
    }else{
        alert("Applicant Registration Failed!!!");
    }
}

