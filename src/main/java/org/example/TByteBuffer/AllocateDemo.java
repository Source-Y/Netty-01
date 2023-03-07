package org.example.TByteBuffer;

import java.nio.ByteBuffer;

/**
 * @author Ivyevy
 * @description:
 */
public class AllocateDemo {
    public static void main(String[] args) {
        /**
         * class java.nio.HeapByteBuffer    - 分配到java堆内容中，受到GC的影响（拷贝-移动），读写效率低
         * class java.nio.DirectByteBuffer  - 分配到操作系统内存中，读写效率高，不受GC影响，但需要进行系统调用，分配效率低
         */
        System.out.println(ByteBuffer.allocate(16).getClass());
        System.out.println(ByteBuffer.allocateDirect(16).getClass());
    }
}
