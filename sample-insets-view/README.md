# Обработки WindowInsets в View

Разработано в качестве материала к статье: https://habr.com/ru/company/kts/blog/687310/

## Примеры

1. System Window Insets <br>
![image](https://github.com/TimurChikishev/Insets/blob/main/sample-insets-view/images/basic_list_inset.gif)<br>
2. Ime Insets (Обработка клавиатуры)<br>
![image](https://github.com/TimurChikishev/Insets/blob/main/sample-insets-view/images/keyboard.gif)<br>
3. DisplayCutout (Immersive mode) 
<br>([LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS](https://developer.android.com/reference/android/view/WindowManager.LayoutParams#LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS) установлен в MainActivity для всего приложения, поэтому displayCutout обрабатывается на всех экранах)<br> 
![image](https://github.com/TimurChikishev/Insets/blob/main/sample-insets-view/images/cutout.gif)<br>
4. StableInsets (Immersive mode)<br>
![image](https://github.com/TimurChikishev/Insets/blob/main/sample-insets-view/images/stable.gif)<br>
5. System Gesture Insets (Исключение жестов) <br>
![image](https://github.com/TimurChikishev/Insets/blob/main/sample-insets-view/images/exclusion.gif)<br>
6. Mandatory Gesture Insets<br>
![image](https://github.com/TimurChikishev/Insets/blob/main/sample-insets-view/images/mandatory.gif)<br>
