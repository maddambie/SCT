const modal = document.getElementById("myModal");
const span = document.getElementsByClassName("close")[0];
let moreDesc = document.getElementById("MoreDesc");


	
	function handleYearLevelChange() {
		var selectedYearLevel = document.getElementById('year_level').value;
		var modalTable = document.querySelector('.modal table');
	    for (let i = 1; i <= 4; i++) {
			var table = document.getElementById(i);
	        if (selectedYearLevel == i) {
				table.style.visibility = "visible"; 
				table.style.position = "";
				table.style.height = "";
				table.style.overflow = "";

	        } else {
				table.style.visibility = "hidden";
				table.style.position = "absolute";
				table.style.height = "0";
				table.style.overflow = "hidden";
	            
	
	        }
	    }
	}


window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
span.onclick = function() {
    modal.style.display = "none";
  }
 
 


function myFunction(value){
	let subject = document.getElementById("subject");
	let description = document.getElementById("description");
	let hidden_studentid= document.getElementById("hidden_studentid");
	let modal_studentid= document.getElementById("modal_studentid");
	if(value == "description"){
		subject.style.display = "none";
		description.style.display = "block";
	}
	else{
		subject.style.display = "block";
		description.style.display = "none";
		modal_studentid.value = hidden_studentid.value;

	}
}
 
 
  function loadDesc(id) {
	  
	  $.ajax({
	      url: `/api/courses`,
	      type: 'POST',
	      data: { id: id },
	      success: function(data) {
	        moreDesc.innerHTML = data;
	       
	      }
	    });
	  modal.style.display = "block";
  }