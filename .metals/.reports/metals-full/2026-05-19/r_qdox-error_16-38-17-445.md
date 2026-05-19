error id: file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-Trabajo10/src/Sistema.java
file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-Trabajo10/src/Sistema.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[15,29]

error in qdox parser
file content:
```java
offset: 263
uri: file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-Trabajo10/src/Sistema.java
text:
```scala
package src;

import java.io.File;
import java.util.Scanner;

public class Sistema {

    private Grafo grafo;
    public Sistema() {
        grafo = new Grafo(30);
    }

   int[][] distancias = grafo.floydWarshall();

mostrarDistancias(distancias)@@;

    private void cargarArchivo() {
        try {
            File archivo = new File("guategrafo.txt");
            Scanner sc = new Scanner(archivo);
            while (sc.hasNext()) {
                String origen = sc.next();
                String destino = sc.next();
                int distancia = sc.nextInt();
                grafo.agregarArco(origen,
                                  destino,
                                  distancia);
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error al leer archivo");
            System.out.println(e.getMessage());
        }
    }
}
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

QDox parse error in file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-Trabajo10/src/Sistema.java