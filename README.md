##### FileOutputStream class
##### A file output stream is an output stream for writing data to a File or to a FileDescriptor.
##### FileOutputStream is meant for writing streams of raw bytes such as image data. For writing streams of characters, consider using FileWriter.

##### 내부저장소 사용
##### 기기의 내부 저장소에 파일을 직접 저장할 수 있습니다. 기본적으로, 내부 저장소에 저장된 파일은 해당 애플리케이션의 전용 파일이며 다른 애플리케이션(및 사용자)은 해당 파일에 액세스할 수 없습니다. 사용자가 애플리케이션을 제거하면 해당 캐시 파일은 제거됩니다.
##### 전용 파일을 내부 저장소에 만들고 쓰려면:
##### 작업 모드와 파일 이름을 사용하여 openFileOutput()을 호출합니다. 그러면 FileOutputStream이 반환됩니다.
##### write()를 사용하여 파일에 씁니다.
##### close()를 사용하여 스트림을 닫습니다.
```java
String FILENAME = "hello_file";
String string = "hello world!";

FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
fos.write(string.getBytes());
fos.close();
```
```java
String str = new String(byte[] bytes, int offset, int length)
```
차례대로 들어가는 파라미터는 1. 읽을 byte 배열 2. 배열의 첫 위치 3. 배열의 길이이고
이를 String 객체로 만들어준다.
ex)
```java
Bytes bytes[] = {h, e, l, l, o};
String str = new String(bytes, 0, 5);
```
str은 "hello" 가 된다.

##### intent로 값을 넘기는 방법
```java
intent.putExtra("position", position);
```
##### Class는 Serializable하지 않기 때문에 넘길 수 없다. String과 기본형 가능, Parce 등도 가능

##### Write를 끝내고 다시 listView 화면을 보여줄 떄, 갱신된 화면을 보여주기 위해 다음과 같은 함수를 쓴다
```java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(requestCode==WRITE_ACTIVITY){
        if(resultCode==RESULT_OK)
        init();
    }

}
```

##### FileInputStream의 쓰임
```java
public static String read(Context context, String fileName) throws IOException {

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fis = context.openFileInput(fileName);

            bis = new BufferedInputStream(fis);
            byte[] byteContainer = new byte[1000];
            int count = 0;
            while ((count = bis.read(byteContainer)) != -1) {
                String str = new String(byteContainer, 0, count);
                stringBuilder.append(str);
            }
        ...
```

##### FileInputStream의 객체를 받아올 때 context.openFileInput을 쓰게 되는데
##### 이때 파라미터로 넘겨지는 fileName은 경로 다 빼고 순수하게 그 파일 이름만 받아오면 된다.
