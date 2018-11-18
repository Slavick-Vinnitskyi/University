with Ada.Integer_Text_IO;
with Ada.Text_IO;
with Ada.Numerics;
with Ada.Numerics.Discrete_Random;
with Ada.Numerics.Elementary_Functions;
use Ada.Numerics.Elementary_Functions;
use Ada.Text_IO;

package body Data is

   protected body Mutex is
      entry Seize when not Owned is
      begin
         Owned := True;
      end Seize;
      Procedure Release is
      begin
         Owned := False;
      end Release;
   end Mutex;


   function F1(O : in Matrix; E : in Matrix; A : in Vector; B : in Vector; N : in Integer) return Vector is
      C : Vector;
   begin

      C := Amount(A, Multiple(Multiple(O, E, N), B, N), N);
      return C;

   end F1;

   function F2(G : in Matrix; K : in Matrix; L : in Matrix; N : in Integer) return Matrix is
      F : Matrix;
   begin

      F := Diff(Multiple(G, Multiple(K, L, N), N), K, N);
      return F;

   end F2;

   function F3(P : in Matrix; R : in Matrix; T : in Vector; N : in Integer) return Vector is
      O : Vector;
   begin

      O := Multiple(Trans(Multiple(P, R, N), N), T, N);
      return O;

   end F3;


   procedure Matrix_Output(A : in Matrix; N : in Integer; S: in String) is
   begin
      My_Mutex.Seize;
     Put_Line(S);
         for i in 1..N loop
            for j in 1..N loop
               Ada.Integer_Text_IO.Put(A(i,j));
            end loop;
            New_Line;
         end loop;

      My_Mutex.Release;
   end Matrix_Output;

-- generating matrix
   procedure Matrix_Generate (A : out Matrix; N : in Integer) is
      type Rand_Range is range 1..10;
      package Rand_Int is new Ada.Numerics.Discrete_Random(Rand_Range);
      seed : Rand_Int.Generator;
      Num : Rand_Range;
   begin
      Rand_Int.Reset(seed);
      for i in 1..N loop
         for j in 1..N loop
            Num := Rand_Int.Random(seed);
            A(i,j) := 1;
            -- A(i, j):= Integer(Num);
         end loop;
      end loop;
   end Matrix_Generate;

--   generating vector
   procedure Vector_Generate (A : out Vector; N : in Integer) is
      type Rand_Range is range 1..10;
      package Rand_Int is new Ada.Numerics.Discrete_Random(Rand_Range);
      seed : Rand_Int.Generator;
      Num : Rand_Range;
   begin
      Rand_Int.Reset(seed);
      for i in 1..N loop
         Num := Rand_Int.Random(seed);
         A(i):= 1;
         -- A(i):= Integer(Num);
      end loop;
    end Vector_Generate;


   procedure Vector_Output(A : in Vector; N : in Integer; S: in String) is
   begin
      My_Mutex.Seize;
      Put_Line(S);
      for i in 1..N loop
         Ada.Integer_Text_IO.Put(A(i));
      end loop;
         New_Line;
      My_Mutex.Release;
   end Vector_Output;

-- sum of two vector
   function Amount ( A: in Vector; B: in Vector; N : in Integer) return Vector is
      C : Vector;
   begin
      for i in 1..N loop
         C(i):=A(i)+B(i);
      end loop;
      return C;
   end Amount;

-- transposition
   function Trans (A: in Matrix; N : in Integer) return Matrix is
      B:Matrix;
   begin
      for i in 1..N loop
         for j in 1..N loop
            B(i,j):=A(j,i);
         end loop;
      end loop;
      return B;
   end Trans;

-- sum of two matrix
   function Amount ( A: in Matrix; B: in Matrix; N : in Integer) return Matrix is
      C:Matrix;
   begin
      for i in 1..N loop
         for j in 1..N loop
            C(i, j):= A(i, j) + B(i, j);
         end loop;
      end loop;
      return C;
   end Amount;

   -- sum of two matrix
   function Diff ( A: in Matrix; B: in Matrix; N : in Integer) return Matrix is
         C:Matrix;
      begin
         for i in 1..N loop
            for j in 1..N loop
               C(i, j):= A(i, j) - B(i, j);
            end loop;
         end loop;
         return C;
      end Diff;

-- multiplicating two matrix
   function Multiple ( A: in Matrix; B: in Matrix; N : in Integer) return Matrix is
      C:Matrix;
   begin
      for row in 1..N loop
         for col in 1..N loop
            C(row,col):=0;
            for inner in 1..N loop
               C(row, col) := C(row, col) + A(row, inner) * B(inner, col);
            end loop;
         end loop;
      end loop;
      return C;
   end Multiple;

-- multiplicating matrix an vector
   function Multiple ( A: in Matrix; B: in Vector; N : in Integer) return Vector is
      C:Vector;
   begin
      for row in 1..N loop
         C(row):=0;
         for col in 1..N loop
            C(row) := C(row) + A(row,col) * B(col);
         end loop;
      end loop;
      return C;
   end Multiple;

end Data;
