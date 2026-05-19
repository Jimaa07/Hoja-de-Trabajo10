error id: file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-Trabajo10/src/Grafo.java
file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-Trabajo10/src/Grafo.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[81,2]

error in qdox parser
file content:
```java
offset: 2218
uri: file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-Trabajo10/src/Grafo.java
text:
```scala
package src;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {

    private final int INF = 999999;
    private int[][] matriz;
    private Map<String, Integer> indices;
    private List<String> ciudades;
    private int cantidad;

    public Grafo(int maxCiudades) {
        matriz = new int[maxCiudades][maxCiudades];
        indices = new HashMap<>();
        ciudades = new ArrayList<>();
        cantidad = 0;

        for (int i = 0; i < maxCiudades; i++) {
            for (int j = 0; j < maxCiudades; j++) {
                if (i == j) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = INF;
                }
            }
        }
    }

    public void agregarCiudad(String ciudad) {

        if (!indices.containsKey(ciudad)) {
            indices.put(ciudad, cantidad);
            ciudades.add(ciudad);
            cantidad++;
        }
    }

    public void agregarArco(String origen, String destino, int distancia) {

        agregarCiudad(origen);
        agregarCiudad(destino);
        int i = indices.get(origen);
        int j = indices.get(destino);
        matriz[i][j] = distancia;
    }

    public void eliminarArco(String origen,String destino) {

        if (indices.containsKey(origen)
                && indices.containsKey(destino)) {
            int i = indices.get(origen);
            int j = indices.get(destino);
            matriz[i][j] = INF;
        }
    }

    public void mostrarMatriz() {
        System.out.print("\t");
        for (String ciudad : ciudades) {
            System.out.print(ciudad + "\t");
        }

        System.out.println();
        for (int i = 0; i < cantidad; i++) {
            System.out.print(ciudades.get(i) + "\t");
            for (int j = 0; j < cantidad; j++) {
                if (matriz[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(matriz[i][j] + "\t");
                }
            }

            System.out.println();
        
    }
}@@
```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:940)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	java.base/java.lang.Thread.run(Thread.java:1583)
```
#### Short summary: 

QDox parse error in file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-Trabajo10/src/Grafo.java