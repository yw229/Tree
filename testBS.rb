  # File:      BinarySearch.rb
class BinarySearch
      def BS (sortedArray, low ,high, key)
          while low <= high
             mid = (low + high) >> 1  # right shif avoid overflow 
              if( sortedArray[mid] == key)
                  return mid 
              else
                   if( sortedArray[mid] < key )
                        low = mid + 1 
                  else
                        high = mid -1 ; 
                  end 
              end
               
            end
        return -1 
       end 
end 


require 'test/unit'

class BinarySearchTest < Test::Unit::TestCase
  def self.it name, &block
    define_method("test_#{name.gsub(/\W/,'_')}", &block) if block
  end

  it 'should give same results as Array # Index' do
    array = (1..100).to_a
    
    1.upto 100 do |i|
      bs = BinarySearch.new 
      expected = bs.BS(array, 0 , array.length - 1, i)
      assert_equal expected, array.index(i)
    end
  end

  it 'should return -1 for empty array' do
      bs = BinarySearch.new 
      expected = bs.BS([], 0 , [].length - 1, 3)
      assert_equal expected, -1
  end
  
  it 'should return 0 for array with only 1 element' do
      bs = BinarySearch.new 
      expected = bs.BS([3], 0 , [3].length - 1, 3)
      assert_equal expected, 0
  end

  it 'should return right index for array with 2 elements' do
   array = [1, 2]
   bs = BinarySearch.new 
   expectedl = bs.BS(array, 0 , array.length - 1, 1)
   expectedr = bs.BS(array, 0 , array.length - 1, 2)
   assert_equal expectedl, 0
   assert_equal expectedr, 1
  end
  
  it 'should return -1 if there is no such element in array' do
    array = (1..100).to_a
    array.delete 98   
    bs = BinarySearch.new 
    expected1 = bs.BS(array, 0 , array.length - 1, 0)
    expected2 = bs.BS(array, 0 , array.length - 1, 102)
    expected3 = bs.BS(array, 0 , array.length - 1, 98)
    assert_equal expected1, -1
    assert_equal expected2, -1
    assert_equal expected3, -1
  end
  
end
