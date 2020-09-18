var username;
var roles;
function logins() {
	
	// kreiramo JavaScript objekat sa podacima koje je korisnik uneo u input polja
	var user = {
		'username' : $('#username').val(),
		'password': $('#password').val()
	}
	
	// podatke na backend uvek saljemo kao JSON string
	var userJSON = JSON.stringify(user);
	
	$.ajax({
	    url : '/auth/login',
	    type: 'POST',
	    data : userJSON,
	    contentType:"application/json; charset=utf-8",
	    dataType:"json",
	    success: function(data)
	    {
	    	// 1. sakrij poruku o gresci ako su pogresni kredencijali posto je korisnik uspesno ulogovan!
	    	$('#wrongCredentialsError').hide();
	    	
	    	// 2. korak: sacuvamo JWT token koji server salje u LocalStorage pod kljucem "jwt"
	    	// sacuvan token mozete videti na sledeci nacin: Otvorite Developer konzolu (F12) -> Application -> Local Storage
	    	var jwt = data.accessToken;
	    	localStorage.setItem('jwt', jwt);
	    	
	    	// 3. iz tokena mozemo da citamo podatke koji su poslati sa serverske strane i cuvati ih u pormenljivima, LocalStorage-u, ...
	    	// mi hocemo da procitamo podatke iz jwt tokena koji smo dobili i upisemo username u promenljivu "username" i uloge u "roles" promenljivu
	    	var decodedJWTData = _decodeJWT(jwt);
	    	if (decodedJWTData != null) {
	    		username = decodedJWTData.sub;
		    	roles = decodedJWTData.roles;
	    	}
	    	
	    	// 4. prikazemo novu formu
	    	showAnotherForm();
	    	
	    },
	    error: function (error)
	    {
	    	// prikazi poruku o gresci ako su pogresni kredencijali
	    	$('#wrongCredentialsError').show();
	    }
	});
}