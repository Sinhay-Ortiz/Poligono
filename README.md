# Planteamiento del problema
Crear un programa que incluya botones para trasladar, rotar y escalar un poligono con OpenGL.

el programa realizado fue escrito en el lengueje JAVA en el etorno NetBeans. A continuacion se presentan las caputuras de pantalla del programa realizado con su respectiva descripcion de como se utilizo, al final se presentan las capturas correspondientes al resultado del programa.

# Codigo Fuente

En la captura 1 se presentan las librerias que se utilizaron par llevar a cabo el programa.


**Figura 1: **Librerias Importadas

[![Captura-1.png](https://i.postimg.cc/1z2mK9D8/Captura-1.png)]

**LA Clase Pricipal **se llama  Transformacion la cual hereda de JFrame . Dentro de esta clase se encuentran los botones trasladar, rotar y escalar****

**Figura 2:**

[![Captura-2.png](https://i.postimg.cc/7PMCq2gX/Captura-2.png)](https://postimg.cc/Z0nYc0sy)

En el constructor de la clse principal **Transformacion **se determinan los detalles que ****se le otrogaron a los botones: trasladar, rotar y escalar.

**Figura 3:**

[![Captura-3.png](https://i.postimg.cc/tgWrTkRY/Captura-3.png)](https://postimg.cc/QBNgYpT3)

Para completar el proceso de Transformacion, se hacen visibles los botones y asi puedan tener una funcion correcta durante la ejecucion del programa.

**Figura 4: **

[![Captura-4.png](https://i.postimg.cc/yY9CMw2Z/Captura-4.png)](https://postimg.cc/F796cnrr)

Una de las funciones principales en cualquier programa, que se trabaje en el entorno JAVA es el metodo main.

**Figura 5:**

[![Captura-5.png](https://i.postimg.cc/RVqNwV6z/Captura-5.png)](https://postimg.cc/ZCtbSmxf)

En la clase denominada **Dibujar** nos permite hacer las figuras de los poligonos en el programa, como se pide en el planteamiento.

**Figura 6:**

[![Captura-6.png](https://i.postimg.cc/hP58FYWV/Captura-6.png)](https://postimg.cc/crftwXJJ)

# Ejecucuion Del Programa

Al ejecutarlo nos muestra la siguiente ventana. contiene tres botones con sus respectivo transformacion de una figura, tambien se muestra un cuadro el cual se haran las transformaciones.


**Figura 1:**

[![1.png](https://i.postimg.cc/3J87MLCr/1.png)](https://postimg.cc/SjvHCfvH)

Al darle clic al boton de trasladar nos mostrara la sigueine ventana, la cual ingresamos las coordenadas en X y Y, lo cual al presionar la tecla traladar se trasladara la figura original con los datos ingresados.

**Figura 2:**

[![2.png](https://i.postimg.cc/hjGDLpyt/2.png)](https://postimg.cc/zL9Y5SYs)

Resultado de la transformacion trasladar:

**Figura 3:**

[![3.png](https://i.postimg.cc/hPQGZZSJ/3.png)](https://postimg.cc/mtRRtw1R)


Al darle clic al boton de rotar, nos muestra la siguiente ventana en donde debemos ingresar los grados en los que queremos rotar dicha figura.

**Figura 4:**

[![4.png](https://i.postimg.cc/XJ2vmTG5/4.png)](https://postimg.cc/qh30CDGB)

Resultado de la trnasformacion rotar.}

**Figura 5:**

[![5.png](https://i.postimg.cc/FK41LbXY/5.png)](https://postimg.cc/w1w6Kmvz)

Al darle clic al boton escalar nos muestra la siguiente ventana el cual le ingresamos valores para los parametros de coordenadas en X y Y. El cual aplicaremos transformacion a la figura original 

**Figura 6:**

[![6.png](https://i.postimg.cc/MG2fY2VK/6.png)](https://postimg.cc/XrLvVPsT)

Resultado de la transformacion de la escalar. La figura original se escalo 0.4 en X y Y.

**Figura 7:**

[![7.png](https://i.postimg.cc/bNVQkBms/7.png)](https://postimg.cc/ZC3BhVtS)
