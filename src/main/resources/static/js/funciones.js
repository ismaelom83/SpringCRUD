function eliminar(id) {
	swal({
		title: "Estas seguro de eliminar?",
		text: "Una vez eliminado, ¡no podrá recuperar este archivo!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminar/"+id,
					success: function(res) {
						console.log(res);
					}
				})
				swal("¡Su archivo ha sido eliminado!", {
					icon: "success",
				}).then((ok)=>{
					if (ok) {
						location.href="/listar";
					}				
				});
			} else {
				swal("¡Su archivo está a salvo!");
			}
		});
}