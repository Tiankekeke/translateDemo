//package com.fy.autolang;
// 
//import static org.junit.Assert.assertTrue;
// 
//import org.junit.Test;
// 
///**
// * @author 吴文旷
// * 
// */
//public class LangDetectorUtilTest {
// 
//	@Test
//	public void test() {
//		// 英文测试
//		String originalStr = "The Distributed File Search (DFS) engine is an out-of-the-box file search engine which searches millions of files of more than a thousand different formats and TB in size in just a few seconds. It allows you to search file contents, file names. You can filter search results by file formats and modified date and so on. It is a distributed file search engine base on Java technology and supports English, Chinese, Arabic, Russian, Japanese and other languages. ";
//		assertTrue(LangDetectorUtil.containsEnglish(originalStr));
//		System.out.println(LangDetectorUtil.getLangUsed(originalStr));
//		
//		//中文测试
//		originalStr = "DFS分布式文件搜索引擎是一个开箱即用的文件搜索引擎，能在几秒钟内搜索数以百万计的、格式超过数千种、大小超过TB的文件。它允许您搜索文件内容、文件名称及文件附加信息，您还可以按文件格式和修改日期等过滤搜索结果。该搜索引擎基于分布式技术，支持英语、中文、阿拉伯语、俄语和日语等多国语言。";
//		assertTrue(LangDetectorUtil.containsChinese(originalStr));
//		System.out.println(LangDetectorUtil.getLangUsed(originalStr));
//		
//		//阿拉伯语测试
//		originalStr="حرك البحث عن الملفات الموزعة (DFS) هو محرك بحث ملف خارج منطقة الجزاء الذي يبحث عن ملايين ملفات من صيغ مختلفة أكثر من ألف والسل في الحجم في ثوان معدودة. أنها تسمح لك بالبحث في محتويات الملف، أسماء الملفات. يمكنك تصفية نتائج البحث بواسطة تنسيقات الملف وتاريخ التعديل وهلم جرا. هو محرك بحث ملفات موزعة على تقنية جافا قاعدة ويدعم الإنكليزية والصينية، والعربية، والروسية، واليابانية ولغات أخرى.";
////		System.out.println(LangDetectorUtil.getLangUsed(originalStr));
//		assertTrue(LangDetectorUtil.containsArabic(originalStr));
//		System.out.println(LangDetectorUtil.getLangUsed(originalStr));
//		
//		//俄文测试
//		originalStr="Двигатель поиска распределенных файлов (DFS) является файл out-of-box поисковая система, которая ищет миллионы файлов из более чем тысячи различных форматов и ТБ в размере в течение нескольких секунд. Это позволяет искать содержимое файлов, имена файлов. Вы можете фильтровать результаты поиска по форматов файлов и Дата изменения и так далее. Это распределенный файл поисковой базы на технологии Java и поддерживает английский, китайский, арабский, Русский, японский и другие языки.";
//		assertTrue(LangDetectorUtil.containsRussian(originalStr));
//		System.out.println(LangDetectorUtil.getLangUsed(originalStr));
//		
//		//日文测试
//		originalStr="分散ファイル検索 (DFS) エンジンは、ほんの数秒でサイズで 1000 人以上の異なるフォーマットと TB のファイルの何百万人を検索するボックスのファイル検索エンジンです。それは、ファイル名、ファイルの内容を検索することができます。ファイル形式で検索結果をフィルターすることができますしてに日付を変更します。Java テクノロジに基づく分散ファイルの検索エンジンがあり、英語、中国語、アラビア語、ロシア語、日本語、他の言語をサポートしています。";
//		assertTrue(LangDetectorUtil.containsJapanese(originalStr));
//		System.out.println(LangDetectorUtil.getLangUsed(originalStr));
//		
//		//德文测试
//		originalStr="Die verteilte Datei Suche (DFS)-Engine ist eine Out-of-the-Box-Datei-Suchmaschine, die Millionen von Dateien unterschiedlicher Formate und TB mehr als tausend in der Größe in nur wenigen Sekunden durchsucht. Es erlaubt Ihnen, Dateiinhalt, Dateinamen zu suchen. Sie können die Suchergebnisse filtern, indem Dateiformate und Änderungsdatum und so weiter. Es ist ein verteiltes Dateisystem Suchmaschine basieren auf Java-Technologie und unterstützt Englisch, Chinesisch, Arabisch, Russisch, Japanisch und anderen Sprachen.";
//		assertTrue(LangDetectorUtil.containsGerman(originalStr));
//		System.out.println(LangDetectorUtil.getLangUsed(originalStr));
//		
//		//葡萄牙语测试
//		originalStr="O motor de busca de arquivos distribuídos (DFS) é um motor de busca de arquivo out-of-the-box que procura milhões de arquivos de diferentes formatos e TB de mais de um milhar de tamanho em apenas alguns segundos. Ele permite que você pesquisar conteúdo de arquivos, nomes de arquivo. Você pode filtrar os resultados da pesquisa pelos formatos de arquivo e data de modificação, e assim por diante. É um motor de busca de arquivos distribuídos base na tecnologia Java e suporta Inglês, chinês, árabe, russo, japonês e outros idiomas.";
//		assertTrue(LangDetectorUtil.containsPortuguese(originalStr));
//		System.out.println(LangDetectorUtil.getLangUsed(originalStr));
//		
//		//西班牙语测试
//		originalStr="El motor de búsqueda de archivos distribuido (DFS) es un motor de búsqueda de archivo fuera de la caja que busca millones de archivos de más de 1 mil formatos y TB en tamaño en unos pocos segundos. Le permite buscar contenido de los archivos, nombres de archivo. Puede filtrar los resultados de la búsqueda por formatos de archivo y modificar la fecha y así sucesivamente. Es un motor de búsqueda de archivos distribuidos en tecnología Java y soporta Inglés, Chino, Árabe, Ruso, Japonés y otros idiomas.";
//		assertTrue(LangDetectorUtil.containsSpanish(originalStr));
//		System.out.println(LangDetectorUtil.getLangUsed(originalStr));
//		
//		//法语测试
//		originalStr="Le moteur de recherche de fichiers distribués (DFS) est un moteur de recherche de fichier out-of-the-box qui recherche des millions de fichiers de différents formats et de la tuberculose plus d’un millier de taille en seulement quelques secondes. Il vous permet de rechercher le contenu du fichier, les noms de fichier. Vous pouvez filtrer les résultats de recherche en formats de fichier et date de modification et ainsi de suite. C’est un moteur de recherche de fichiers distribués base sur la technologie Java et prend en charge l’anglais, chinois, arabe, russe, japonais et autres langues.";
//		assertTrue(LangDetectorUtil.containsFrench(originalStr));
//		System.out.println(LangDetectorUtil.getLangUsed(originalStr));
//		
//		//下面测试一下中英文混合语言的情况：
//		//混合语言
//		originalStr="DFS分布式文件搜索引擎是一个开箱即用的文件搜索引擎,The Distributed File Search (DFS) engine is an out-of-the-box file search engine which searches millions of files";
//		//下面的语句打印出en，表示这行文字主要的语言为英文
//		System.out.println(LangDetectorUtil.getLangUsed(originalStr));
//	
//		originalStr="DFS分布式文件搜索引擎是一个开箱即用的文件搜索引擎，能在几秒钟内搜索数以百万计的、格式超过数千种、大小超过TB的文件。它允许您搜索文件内容、文件名称及文件附加信息， The DFS engine is a file search engine.";
//		//下面的语句打印出zh-cn，表示这行文字主要的语言为中文
//		System.out.println(LangDetectorUtil.getLangUsed(originalStr));
//		
//		originalStr="持续创新，不断改进——各种技术在Kern River重油油田开发中的应用   World Oil, August 2010 (http://www.worldoil.com/Historical-and-continuing-technology-application-at-a-giant-heavy-oil-field.html) James F. Swartz, Charles Piestch and Stephen D. Cassidy, Chevron North America E&P Company, 国外勘探开发信息网编译  摘要 Kern River油田位于加州洛杉矶东北90英里处的圣华金谷(San Joaquin Valley)（位置见图一），是美国最大的重油油田之一，该油田发现于1899年，地质储量估计为35亿桶。从20世纪60年代开始，对该油田实施蒸汽驱开发后，产量翻了7倍，从原来的19000桶每天增加到1985年的142000桶每天，在1980到2000年期间，蒸汽驱使该重油油田的产量一直大于120000桶每天。现在的产量虽如有所下降，但日产量仍然维持在78000桶左右。截至2007年，该油田的累计产量达到20亿桶；迄今为止，该油田的总钻井数超过2万口。从上世纪90年代开始，人们在该油田不断地应用了各种技术，提高了该油田的采收率，降低了产量递减率，延长了该油田的生命周期。这些技术创新包括：利用大量的开发井信息，在地质统计学的基础上对全油田进行了三维地质建模；最近，水平井技术也提高了这个老油田的采收率；而且，该油田现在正在实施一个项目，通过降低底部含水层的压力来提高热传导的效率，从而对含有残余油的较低层位进行开发。   油藏描述   该油藏由含砾的辫状河道砂组成，油藏顶部深度为100到1000英尺，孔隙度29－33％，渗透率1－8达西。该油藏在垂向上分9个开发小层。由于辫状河道沉积连续性的变化，每一小层的地层也变得很复杂。Kern River油田生产重油，储集层为上中新统未固结河湖相Kern River石英长石砂岩，产层厚度约800英尺，产层的净毛比为76%；该油田原油的API度为13度，在原始油藏温度下的原油粘度为4000 cP。Kern River油田是一个位于San Joaquin盆地东翼的单斜构造，上覆在东西走向的Bakersfield Arch上，单斜倾向西南，倾角约4° 。原油的顶部形状和等势面一致，表明原油在静水压力作用下运移。原油的埋藏深度很浅，有的地方离地表只有50米。   技术创新在Kern River油田的应用   KernRiver油田应用蒸汽驱开发近50年，因此，该油田长期以来被人们当作蒸汽驱研究的天然实验室。开始，人们在该油田成功使用了井底加热器，但短期的注热水开发并不是很成功，这是因为该油田河道砂分支严重；人们于1962年开始对该油田进行蒸汽驱试验，刚开始只对生产井进行循环蒸汽驱，使采收率有所提高。在20世纪60年代末，人们对Kern River油田实施全油田蒸汽驱（见图二），布井方式一般采用矩形法，即一口注入井布在4到8个生产井中间，井距为2.5英亩。     有关Kern River重油油田参考文献  Actuary, G., 2009, A Visit to Chevron's Kern River Heavy Oil Facility, http://www.theoildrum.com/node/5023 Actuary, G., 2009, Kern River Production Estimates versus What is Economic, http://www.theoildrum.com/node/5098. Bandy, O.L., and Arnal, R.E., 1969, Middle Tertiary basin development, San Joaquin Valley, California: Geological Society of America Bulletin, v. 80, no. 5, p.783-820. Baumann, C. E., Osterloh, W. T., Temple R. C., and Lolley, C. S., 2002, Full Field Simulation of Aquifer Interdiction in the Kern River Field, California, SPE Paper no. 14337 Bent, J.V., 1985, Provenance of upper Oligocene - middle Miocene sandstones of the San Joaquin Basin, California, in Graham, S.A., ed., Geology of the Temblor Formation, western San Joaquin Basin, California: Los Angeles, Pacific Section, Society of Economic Paleontologists and Mineralogists, v. 44, p. 97-120. Brelih, D.A., and Kodl, E.J., 1990, Detailed mapping of fluvial sandbodies improves perforating strategy at Kern River Field: Proceedings SPE 60th California Regional Meeting, SPE Paper no. 20080. Bursell, C. G., and G. M. Pittman, 1975, Performance of steam displacement in the Kern River field: Journal of Petroleum Technology, v. 27, p. 997-1004. California Department of Conservation, Division of Oil, Gas, and Geothermal Resources (DOGGR), 1998, California oil & gas fields, volume 1, central California: California Dept. of Conservation, Division of Oil and Gas, publication TR11. California Department of Conservation, Division of Oil, Gas, and Geothermal Resources (DOGGR), 2005, Oil and Gas Production: History in California, ftp://ftp.consrv.ca.gov/pub/oil/history/History_of_Calif. California Department of Conservation, Division of Oil, Gas, and Geothermal Resources (DOGGR), 2008, Oil, Gas & Geothermal - Geothermal - Annual Reports, http://www.conservation.ca.gov/dog/pubs_stats/annual_reports/Pages/annual_reports.aspx. Coburn, M.G., et al., 2002, A hydrologic study to optimize steamflood performance in a giant oilfield, Kern River Field, California  Coodey, K., Horton, R.A. and Knauer, L.C., 2008, Study of Kern River Formation Channel Sands, Kern River Oil Field";
//		//下面的语句打印出en，表示这行文字主要的语言为英文，不知它是如何得到这个的？
//		System.out.println(LangDetectorUtil.getLangUsed(originalStr));
//	}
// 
//}
