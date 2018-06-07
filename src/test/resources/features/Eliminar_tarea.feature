Feature: Eliminar tarea de la lista

Scenario: eliminar tarea
  Given que el usuario desea eliminar la  tarea estudiar
  When el usuario elimina la tarea estudiar
  Then la tarea estudiar se elimina de la lista
  And se reduce el contador de tareas pendientes