import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.neftaly.todolist.ui.model.plantilla

@Composable
fun EditionComponent(
    task: plantilla,
    showDialog: Boolean,
    onClose: () -> Unit,
    onConfirm: (String, String) -> Unit
) {
    val (_title, setTitle) = remember { mutableStateOf(task.title.value) }
    val (_description, setDescription) = remember { mutableStateOf(task.description.value) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = onClose,
            title = { Text("Editar tarea") },
            text = {
                Column {
                    OutlinedTextField(
                        value = _title,
                        onValueChange = setTitle,
                        label = { Text("Título") }
                    )
                    OutlinedTextField(
                        value = _description,
                        onValueChange = setDescription,
                        label = { Text("Descripción") }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirm(_title, _description)
                        onClose()
                    },
                    enabled = _title.isNotBlank() && _description.isNotBlank()
                ) {
                    Text("Guardar")
                }
            },
            dismissButton = {
                TextButton(onClick = onClose) {
                    Text("Cancelar")
                }
            }
        )
    }
}