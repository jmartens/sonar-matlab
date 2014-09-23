classdef (Sealed) classFull < handle

	enumeration
		Enum1
		Enum2 (2)
	end

	events
		Event1
	end

	methods (Static)
		Method1
	end

	properties (Access = private)
		Property1 = test
	end
    
end