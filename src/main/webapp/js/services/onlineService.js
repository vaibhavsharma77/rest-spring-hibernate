app.service('bookingService',function(){
	var uid=0;
	var contacts=[];
	//save new contacts and edit existing contacts
	this.save=function(contact){
		if(contact.id==null){
			contact.id= uid++;
			contacts.push(contact);
		}else{
			for(var i in contacts){
				if(contacts[i].id==contact.id){
					contacts[i].id=contact;
				}
			}
		}
	};
	//fetch record based on id
	this.get=function(id){
		for(var i in contacts){
			if(contacts[i].id==id){
				return contacts[i];
			}
		}
	};
	//remove record based on id
	this.remove=function(id){
		for(var i in contacts){
			if(contacts[i].id==id){
				contacts.splice(i,1);
			}
		}
	};
	this.list=function(){
		return contacts;
	}
})