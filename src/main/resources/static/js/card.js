
document.addEventListener('DOMContentLoaded', function() {
	var rows = document.querySelectorAll('.custom-width.card');

	rows.forEach(function(row) {
		var cells = row.querySelectorAll('td');

		// Para cada célula, ajuste o estilo
		cells.forEach(function(cell) {
			cell.style.display = 'block';
			cell.style.marginBottom = '10px'; // Ajuste a margem conforme necessário
		});

		row.style.display = 'inline-block';
		row.style.marginRight = '10px'; // Ajuste a margem conforme necessário
	});
});



